
/*
    自连接
 */



select e1.name Employee from Employee e1 join Employee e2 on e1.managerId = e2.id and e1.salary > e2.salary