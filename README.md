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
