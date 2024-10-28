# Photoz Clone

Photoz Clone is a Spring Boot application for managing photos. It provides functionalities to upload, download, and display photos.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Endpoints](#endpoints)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. **Clone the repository:**

    ```sh
    git clone https://github.com/your-username/photoz-clone.git
    cd photoz-clone
    ```

2. **Build the project:**

    ```sh
    mvn clean install
    ```

3. **Run the application:**

    ```sh
    mvn spring-boot:run
    ```

## Usage

Once the application is running, you can interact with it using a tool like Postman or curl.

### Upload a Photo

To upload a photo, send a POST request to `/photoz` with the photo data.

Example using curl:

```sh
curl -X POST http://localhost:8080/photos -H "Content-Type: application/json" -d '{"id": "1", "fileName": "example.jpg", "contentType": "image/jpeg", "data": "base64-encoded-data"}'