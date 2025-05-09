echo SELECT 'CREATE DATABASE librarymanagementsystem_product_testingcode' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'librarymanagementsystem_product_testingcode') \gexec | psql "postgresql://postgres:admin@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:admin@localhost/librarymanagementsystem_product_testingcode"

java -cp librarymanagementsystem.product.testingcode --module-path librarymanagementsystem.product.testingcode -m librarymanagementsystem.product.testingcode