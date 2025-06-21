# customermanagementservice


###  Müşteri Yönetim Mikroservisi

Bu proje, müşteri verilerinin yönetimi için geliştirilmiş, Spring Boot tabanlı ve PostgreSQL destekli konteynerleştirilmiş bir mikroservistir. Temiz katman mimarisi ile geliştirilmiş olan uygulama, RESTful API üzerinden müşteri CRUD işlemleri sunar.

---


-  Müşteri verileri için RESTful API (CRUD)
-  Docker ve PostgreSQL ile tam entegre altyapı
-  Controller, Service ve Repository katmanlarında ayrık mimari
-  JUnit 5 ile kapsamlı testler
-  Modern Spring Boot uygulama yapısına uygun geliştirme

---



### Kullanılan Teknolojiler
Java 17

Spring Boot

Spring Data JPA (Hibernate)

PostgreSQL (Docker ile)

Maven

JUnit 5


| Yöntem | Endpoint              | Açıklama                   |
| ------ | --------------------- | -------------------------- |
| GET    | `/api/customers`      | Tüm müşterileri getirir    |
| GET    | `/api/customers/{id}` | Belirli ID’ye göre getirir |
| POST   | `/api/customers`      | Yeni müşteri oluşturur     |
| PUT    | `/api/customers/{id}` | Mevcut müşteriyi günceller |
| DELETE | `/api/customers/{id}` | Müşteriyi siler            |


###  Kurulum ve Çalıştırma

Projeyi klonlayın ve Docker ile başlatın:

```bash
git clone https://github.com/kubraaucar/customer-management-service.git
cd customer-management-service
docker-compose up --build



