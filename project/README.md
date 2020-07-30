# v8.2 第四天

## 延迟加载 - 一对多的延迟加载查询:

用户User     账户Account

1              N

-> 一个用户可能会有多个账户


***立即加载：***

select * from a.*,u.username,u.sex from account a,user u where a.uid = u.id;

***延迟加载：***
> 要写2条SQL

1. 先查询出用户：

select * from user

2. 查询用户拥有哪些账号：
select * from account where uid = 用户的主键;




 



