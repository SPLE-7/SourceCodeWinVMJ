echo SELECT 'CREATE DATABASE librarymanagementsystem_product_basic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'librarymanagementsystem_product_basic') \gexec | psql "postgresql://postgres:admin@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:admin@localhost/librarymanagementsystem_product_basic"

java -cp librarymanagementsystem.product.basic --module-path librarymanagementsystem.product.basic -m librarymanagementsystem.product.basic