# DevOps Session 11 - Bài Tập 3: Tối Ưu Tốc Độ CI Bằng Gradle Dependency Caching

Dự án mẫu Java 17 / Gradle tích hợp GitHub Actions CI Workflow với tính năng **Gradle Dependency Caching** thông qua `actions/setup-java@v5` (`cache: 'gradle'`).

---

## 1. Cấu Trúc Dự Án

```text
bt3/
├── .github/
│   └── workflows/
│       └── ci.yml             # GitHub Actions CI Workflow (có cache: 'gradle')
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── src/
│   ├── main/java/com/devops/demo/
│   │   ├── App.java
│   │   └── CalculatorService.java
│   └── test/java/com/devops/demo/
│       ├── AppTest.java
│       └── CalculatorServiceTest.java
├── .gitignore
├── build.gradle               # Cấu hình dự án Java & dependencies
├── gradlew                    # Gradle wrapper script (Linux/macOS)
├── gradlew.bat                # Gradle wrapper script (Windows)
├── settings.gradle            # Tên project
├── report.md                  # Báo cáo so sánh chi tiết thời gian & logs 2 lần chạy
└── README.md
```

---

## 2. Điểm Nhấn Tối Ưu Trong Kịch Bản CI (`.github/workflows/ci.yml`)

```yaml
      - name: Thiết lập môi trường Java JDK 17
        uses: actions/setup-java@v5
        with:
          java-version: '17'
          distribution: 'temurin'
          cache: 'gradle'  # Bật Gradle Dependency Caching
```

---

## 3. Kết Quả Tối Ưu

| Tiêu chí | Lần 1 (Chưa Cache) | Lần 2 (Đã Cache) | Mức độ cải thiện |
| :--- | :---: | :---: | :---: |
| **Bước setup-java** | ~4s (chưa có cache) | ~8s (tải cache về) | Nạp cache nội bộ GitHub |
| **Bước ./gradlew test** | **1m 35s** | **12s** | **Giảm ~87.4%** |
| **Tổng thời gian Job** | **2m 30s** | **29s** | **Giảm ~80.7%** (Nhanh gấp >5 lần) |
| **Trạng thái Cache** | Cache Miss | **Cache Hit** | `Cache restored successfully from key: gradle-...` |

Chi tiết báo cáo phân tích sâu xem tại [report.md](report.md).
