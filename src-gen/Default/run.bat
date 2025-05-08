echo SELECT 'CREATE DATABASE librarymanagementsystem_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'librarymanagementsystem_product_default') \gexec | psql "postgresql://:@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://:@localhost/librarymanagementsystem_product_default"

java -cp librarymanagementsystem.product.default --module-path librarymanagementsystem.product.default -m librarymanagementsystem.product.default