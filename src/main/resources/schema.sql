-- Create Department Table
CREATE TABLE IF NOT EXISTS department (
                                          id SERIAL PRIMARY KEY,
                                          name VARCHAR(255) NOT NULL UNIQUE
);

-- Create Employee Table
CREATE TABLE IF NOT EXISTS employee (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
                                        type VARCHAR(255) NOT NULL,
                                        is_full_time BOOLEAN NOT NULL,
                                        department_id INT,
                                        FOREIGN KEY (department_id) REFERENCES department(id)
);

-- Create WorkLog Table
CREATE TABLE IF NOT EXISTS work_log (
                                        id SERIAL PRIMARY KEY,
                                        week_id INT NOT NULL,
                                        week_start DATE NOT NULL,
                                        week_end DATE NOT NULL,
                                        hours_worked INT NOT NULL,
                                        employee_id INT,
                                        FOREIGN KEY (employee_id) REFERENCES employee(id)
);
