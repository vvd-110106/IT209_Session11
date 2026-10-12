# DevOps Session 11 - Bài 4: Khai Báo GitHub Secrets & Đăng Nhập Container Registry (GHCR)

## Tổng Quan Bài Tập
- **Mục tiêu**: Thiết lập GitHub Repository Secret (`REGISTRY_TOKEN`) và cấu hình bước đăng nhập tự động vào **GitHub Container Registry (`ghcr.io`)** bằng `docker/login-action@v3`.
- **Thư mục bài tập**: `bt4/`
- **Thư mục nộp bài chuẩn**: `homework/session_11/ex4/`

---

## Các Tệp Sản Phẩm
1. `.github/workflows/ci.yml`: Workflow CI có bước `docker/login-action@v3`.
2. `github_secrets_registry_token.png`: Ảnh chụp màn hình minh chứng cấu hình Repository Secrets.
3. `report.md`: Báo cáo chi tiết từng bước tạo PAT, cấu hình Secrets, và trích xuất log `Login Succeeded`.
4. `Dockerfile`: Multi-stage build đóng gói ứng dụng Java.
5. Mã nguồn dự án Java/Gradle (`build.gradle`, `settings.gradle`, `gradlew`, `src/`).

---

## Kịch Bản Đăng Nhập Mẫu
```yaml
      - name: Đăng nhập vào GitHub Container Registry
        uses: docker/login-action@v3
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.REGISTRY_TOKEN }}
```

Xem chi tiết hướng dẫn và log tại [report.md](report.md).
