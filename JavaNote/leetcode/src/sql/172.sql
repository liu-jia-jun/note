

/*
175. 组合两个表
外连接 :
        select 字段 , 字段 ... from table1 left join table2 on 条件

内连接 :
        select 字段 , 字段 ... from table1  join table2 on 条件

区别:
    1. 内连接与外连接 语法相似 , 主要靠 是否有 left 或者 right 关键字
    2. 左外连接 -- 将sql 语句中左边的 表作为主表 右外连接 -- 将sql 语句中右边的表作为主表
    3. 作为主表的表中的记录会被全部查询出来 , 作为次表 中的记录会根据 on 关键字中的条件进行判断 如果匹配则显示 如果不匹配则显示为null

    4. 如果是内连接 两张表无主次之分 如果条件不成立 那么 内连接中 两张表 不符合条件的记录 都不会显示出来 这也是内外连接的主要区别

    5. 内连接是交集 , 外连接是并集

*/

select firstName , lastName , city , state from person left join address on person.personId = address.personId;