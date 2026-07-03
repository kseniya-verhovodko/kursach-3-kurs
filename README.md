KV Mode — Система автоматизации бизнес-процессов салона красоты
KV Mode — это полнофункциональное клиент-серверное веб-приложение для автоматизации работы салона красоты. 
Проект позволяет клиентам записываться на услуги в режиме онлайн, мастерам — управлять своим расписанием, 
а администраторам — контролировать работу всего заведения через аналитическую панель.
### Стек технологий
Backend: Java 17, Spring Boot, Spring Data JPA, Spring Security.
Frontend: Angular 16, TypeScript, Bootstrap.
База данных: MySQL 8.0.
Инструменты: Maven.

### Скриншоты интерфейса
#### Главная страница	
<img width="974" height="414" alt="img_1" src="https://github.com/user-attachments/assets/b35e0546-3897-4605-aec8-758e18e3f07a" />


#### Каталог услуг
<img width="974" height="407" alt="img_2" src="https://github.com/user-attachments/assets/3ad6ced8-2616-4abf-a21a-18b652bb1540" />

#### Вход
<img width="673" height="512" alt="img_3" src="https://github.com/user-attachments/assets/070c161b-0b6e-4208-8e60-2661a4893964" />

#### Регистрация
<img width="523" height="864" alt="img_4" src="https://github.com/user-attachments/assets/4f1f4f95-a988-4811-991a-44b654bb3b7a" />

#### Оформление записи
<img width="584" height="689" alt="img_5" src="https://github.com/user-attachments/assets/e54e625b-1f7d-49e1-bfe9-c207e2bc598d" />
<img width="993" height="422" alt="img_6" src="https://github.com/user-attachments/assets/ea8bd6ea-4085-4256-a586-461a3b5ce2f0" />

#### Панель администратора	
<img width="974" height="248" alt="img_8" src="https://github.com/user-attachments/assets/5d29d43a-f3c8-49c5-8869-16fa7f186229" />

#### Календарь мастера
<img width="974" height="562" alt="img_7" src="https://github.com/user-attachments/assets/46e0329f-7541-4f59-b826-f9bdad25920e" />

### Ключевой функционал 
Система ролей: Разграничение доступа для трех типов пользователей: Клиент, Мастер, Администратор.
Умное бронирование: Реализована логика проверки доступности временных слотов (валидация на бэкенде). Система исключает двойные записи на одно время.
Безопасность: Хэширование паролей с помощью BCrypt, защита от SQL-инъекций через использование Spring Data JPA (Prepared Statements) и валидация входных данных.
Аналитика для бизнеса: Встроенные инструменты для отслеживания популярности услуг.
Обратная связь: Система отзывов с модерацией со стороны администратора.

### Архитектура данных
Проект использует реляционную модель данных. 
Основные сущности:
appointments — хранит данные о записях (связи с клиентом и мастером).
master / admin / registeration — таблицы пользователей и персонала.
add_service — каталог услуг с категориями и ценами.
feedbacks — отзывы и оценки клиентов.
audit_log — логирование критических изменений в системе.

### Запуск проекта
Frontend: http://localhost:4200
Backend API: http://localhost:9000
