# Running postgres
>docker run --name finman-postgres -e POSTGRES_DB=finman -e POSTGRES_USER=finman -e POSTGRES_PASSWORD=finman123 -p 5432:5432 -d postgres