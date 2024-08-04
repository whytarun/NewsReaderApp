# News Reader App

## Overview

A modern Android app built with Jetpack Compose that provides a seamless news reading experience.

## Key Features

- **Browse News**: View a list of news articles with titles and summaries.
- **Read Full Articles**: Tap to read the full content of an article.
- **Bookmark Articles**: Save articles for later reading.
- **Filter by Category**: Filter news based on categories.

## Technical Requirements

- **Latest & Best Practices**: Implemented using the latest Android development practices and libraries.
- **Modern Libraries**:
  - **Jetpack Compose** for UI development.
  - **Retrofit** for network requests.
  - **Room** for local database storage.
  - **Coil** for image loading.
  - **Paging** for efficient data loading.
  - **Dagger Hilt** for dependency injection.

## Kotlin Coroutines

- **Asynchronous Programming**: Kotlin Coroutines are used to handle asynchronous tasks and manage background operations efficiently. They help in performing network requests, database operations, and other long-running tasks without blocking the main thread.
- **Flow API**: Utilized for managing and observing data streams, providing a reactive and efficient way to handle data changes and updates.
- **Scoped Coroutines**: Coroutines are scoped to lifecycle events, ensuring that background tasks are properly managed and canceled when no longer needed, 

## Implementation Details

- **Public News API**: Utilized a public news API to fetch articles.
- **Architecture**: Clean architecture with separation of concerns between data, domain, and presentation layers.
- **State Management**: Leveraged Kotlin Coroutines and Flow for state management and asynchronous operations.

## Testing Strategy

- **Mockito**: For mocking dependencies in unit tests.
- **Espresso**: For UI testing.
- **JUnit**: For running unit tests and assertions.

## App Architecture
<img width="802" alt="AppArchitecture" src="https://github.com/user-attachments/assets/548f19b5-472d-4209-9bac-d7c8056c0a28">

## App Preview

<img width="314" alt="HomeScreen" src="https://github.com/user-attachments/assets/2abf104f-ef91-4501-88c4-eccd0f26f1c6">
<img width="311" alt="SearchScreen" src="https://github.com/user-attachments/assets/c0271b95-70ca-4c0e-a1ca-4aa99ccd9def">
<img width="353" alt="FilterCategory_1" src="https://github.com/user-attachments/assets/2c68fa1d-4fb1-4f9b-a70c-339faef16625">
<img width="337" alt="FilterCategory_2" src="https://github.com/user-attachments/assets/0890c331-a6e8-4463-a7ac-1480d505aa65">
<img width="311" alt="DetailScreen" src="https://github.com/user-attachments/assets/b9e2b22e-3113-4b7f-b7b7-de963d659a98">
<img width="312" alt="BookMarkScreen" src="https://github.com/user-attachments/assets/b84e7d4e-49db-412b-bfe7-6fdfd6db9238">





