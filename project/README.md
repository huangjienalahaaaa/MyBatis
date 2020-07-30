# v8.1 第四天

## 延迟加载 - 多对一的延迟加载查询:

用户User     账户Account

1              N


-> 一个用户可能会有多个账户




***立即加载：***

select * from a.*,u.username,u.sex from account a,user u where a.uid = u.id;

***延迟加载：***
> 要写2条SQL

1. 先查询出账号：

select * from account

2. 查询账户属于哪一个用户：
select * from user where id =1 ;




 



