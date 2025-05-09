#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE librarymanagementsystem_product_testingcode' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'librarymanagementsystem_product_testingcode') \gexec" | psql "postgresql://postgres:admin@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:admin@localhost/librarymanagementsystem_product_testingcode"
done

java -cp librarymanagementsystem.product.testingcode --module-path librarymanagementsystem.product.testingcode -m librarymanagementsystem.product.testingcode &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait