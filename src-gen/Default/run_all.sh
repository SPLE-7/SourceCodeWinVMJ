#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE librarymanagementsystem_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'librarymanagementsystem_product_default') \gexec" | psql "postgresql://:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://:@localhost/librarymanagementsystem_product_default"
done

java -cp librarymanagementsystem.product.default --module-path librarymanagementsystem.product.default -m librarymanagementsystem.product.default &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait