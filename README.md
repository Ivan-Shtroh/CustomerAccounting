# CustomerAccounting
Приложение это WEB-сервис которое позволяет создавать, находить, изменять и удалять клиентов в базе данных.

Стек Java, Maven, PostgreSQL
Проект использует также Spring Boot, Hibernate, Tomcat через зависимости maven

Создание клиента происходит приемом JSON запроса

Аналогично реализовано изменение клиента и, отдельно, изменение фактического адреса

Данные хранятся в двух таблицах: customer и address, поля registeredAddress и actualAddress ссылаются на таблицу Address посредством связи OneToOne через Hibernate.
    
    Удаление и Поиск клиента реализованы через параметры адресной строки
    Примеры:
      localhost:8080/show_customers?firsName=Vasya&lastName=Pupkin - поиск
      localhost:8080/delete_customer/3 - удаление
        
