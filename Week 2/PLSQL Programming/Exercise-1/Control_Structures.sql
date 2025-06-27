CREATE TABLE Customers (
    customer_id NUMBER(4) Constraint id_pk PRIMARY KEY,
    name VARCHAR2(20),
    age NUMBER,
    balance NUMBER(10,2),
    is_vip CHAR(1) DEFAULT 'N',
    CONSTRAINT chk_is_vip CHECK (is_vip IN ('Y', 'N'))
);

CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER(5,2),
    principal_amount NUMBER(15,2),
    due_date DATE,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

INSERT INTO Customers VALUES (1, 'Indrajit Vig', 63, 20000.00, 'N');
INSERT INTO Customers VALUES (2, 'Gokul Venkataraman', 35, 7894.00, 'N');
INSERT INTO Customers VALUES (3, 'Shray Biswas', 60, 17050.00, 'Y');
INSERT INTO Customers VALUES (4, 'Shanaya Garg', 71, 6400.50, 'N');
INSERT INTO Customers VALUES (5, 'Onkar Sheth', 42, 12500.70, 'N');

INSERT INTO loans VALUES (101, 1, 5.25, 50000.00, '16-AUG-2025');
INSERT INTO loans VALUES (102, 2, 6.75, 35000.00, ADD_MONTHS(SYSDATE, 4));
INSERT INTO loans VALUES (103, 3, 4.50, 100000.00, '28-JUN-2025');
INSERT INTO loans VALUES (104, 4, 7.25, 20000.00, '22-JUL-2025');
INSERT INTO loans VALUES (105, 5, 5.75, 60000.00, ADD_MONTHS(SYSDATE, 15));

set pagesize 500;
set linesize 500;

Select * from Customers;
Select * from loans;


--Scenario-1
DECLARE
    CURSOR c_customers IS
        SELECT c.customer_id, c.age, l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60;
    
    v_discount_rate NUMBER := 1; -- 1% discount
BEGIN
    FOR cust_rec IN c_customers LOOP
        UPDATE loans
        SET interest_rate = interest_rate - v_discount_rate
        WHERE loan_id = cust_rec.loan_id;
        
        DBMS_OUTPUT.PUT_LINE('Applied 1% discount to customer ID ' || cust_rec.customer_id || 
                             ' (age ' || cust_rec.age || '). New rate: ' || 
                             (cust_rec.interest_rate - v_discount_rate) || '%');
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Discount application complete.');
END;
/


--Scenario-2
DECLARE
    CURSOR c_customers IS
        SELECT customer_id, name, balance
        FROM customers
        WHERE balance > 10000 AND is_vip = 'N';
    
    v_vip_count NUMBER := 0;
BEGIN
    FOR cust_rec IN c_customers LOOP
        -- Updating VIP status
        UPDATE customers
        SET is_vip = 'Y'
        WHERE customer_id = cust_rec.customer_id;
        
        DBMS_OUTPUT.PUT_LINE('Promoted ' || cust_rec.name || ' (ID: ' || cust_rec.customer_id || 
                             ') to VIP status.');
    END LOOP;
END;
/


--Scenario-3
DECLARE
    CURSOR c_due_loans IS
        SELECT c.customer_id, 
               c.name AS customer_name,
               l.loan_id,
               l.principal_amount,
               l.due_date,
               ROUND(l.due_date - SYSDATE) AS days_remaining
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
        ORDER BY l.due_date;
        
    v_reminder_count NUMBER := 0;
    v_today DATE := SYSDATE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('********** LOAN PAYMENT REMINDERS **********');
    DBMS_OUTPUT.PUT_LINE('* Due within 30 days (' || TO_CHAR(v_today, 'DD-MON-YYYY') || ' to ' || 
                         TO_CHAR(v_today + 30, 'DD-MON-YYYY') || ')');
    DBMS_OUTPUT.PUT_LINE('********************************************');
    DBMS_OUTPUT.PUT_LINE('');
    
    FOR loan_rec IN c_due_loans LOOP
        -- Printing reminder details for each loan
        DBMS_OUTPUT.PUT_LINE('Dear ' || loan_rec.customer_name || ',');
        DBMS_OUTPUT.PUT_LINE('Your loan #' || loan_rec.loan_id || ' for $' || 
                            TO_CHAR(loan_rec.principal_amount, '999,999.99') || 
                            ' is due in ' || loan_rec.days_remaining || ' days.');
        DBMS_OUTPUT.PUT_LINE('Due Date: ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY'));
        DBMS_OUTPUT.PUT_LINE('Please ensure payment is made by the due date to avoid late fees.');
        DBMS_OUTPUT.PUT_LINE('----------------------------------------');
        
        v_reminder_count := v_reminder_count + 1;
    END LOOP;
    
    -- Output Summary
    DBMS_OUTPUT.PUT_LINE('');
    DBMS_OUTPUT.PUT_LINE('Reminder Summary:');
    DBMS_OUTPUT.PUT_LINE('- Total reminders sent: ' || v_reminder_count);
END;
/
