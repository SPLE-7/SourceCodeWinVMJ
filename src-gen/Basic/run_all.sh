#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE librarymanagementsystem_product_basic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'librarymanagementsystem_product_basic') \gexec" | psql "postgresql://:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://:@localhost/librarymanagementsystem_product_basic"
done

java -cp librarymanagementsystem.product.basic --module-path librarymanagementsystem.product.basic -m librarymanagementsystem.product.basic &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait