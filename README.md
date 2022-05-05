# Đây là dự án tracking order phục vụ việc theo dõi tình trạng đơn hàng.
### Đầu tiên, bạn phải có một server KEYCLOAK để tạo một server phân quyền,
        Link tải KEYCLOAK: [Download](https://www.keycloak.org/archive/downloads-12.0.4.html)
        Hướng dẫn cấu hình KeyCloak cho spring boot:
        [Hướng dẫn](https://www.baeldung.com/spring-boot-keycloak (lưu ý chạy ở cổng 8180))
### Dự án bao gồm 6 dịch vụ con được viết bằng java spring boot, chạy theo thứ
### tự như sau:
#### discovery-server:
    - `mvn clean package && mvn spring-boot:run`
#### api-gateway-service:
    - `mvn clean package && mvn spring-boot:run`
#### configuraion-server:
    - `mvn clean package && mvn spring-boot:run`
#### order-detail-service:
    - `mvn clean package && mvn spring-boot:run`
#### order-service:
    - `mvn clean package && mvn spring-boot:run`
#### tracking-order-n15:
    - `mvn clean package && mvn spring-boot:run`
#### Riêng mail service đã được public lên remote nên không cần chạy.

### Kiểm tra, chạy url tương ứng:
    #### Lấy token từ KEYCLOAK server: tham khảo tại
    [Generate token](https://medium.com/@bcarunmail/securing-rest-api-using-keycloak-and-spring-oauth2-6ddf3a1efcc2)
    #### Sau đó sử dụng token này để gửi request tracking đến task-service.
    `$ curl -h "Authorization: Bearer #{Token}" http://localhost:7000/api/task-service/order/#{code}`
