# Sorting Algorithm Visualizer using Multithreading in Java

## Overview

This project is a **Sorting Algorithm Visualizer** built with Java, using **multithreading** for real-time visualizations of popular sorting algorithms. The visualizer illustrates how different algorithms work step-by-step by displaying the sorting process on the screen.

This project uses the **Processing** library for graphical rendering and focuses on delivering a fast, responsive, and visually appealing experience by harnessing the power of **multithreading**.

## Features

- **Multiple Sorting Algorithms**: Visualize various sorting algorithms such as:
  - Bubble Sort
  - Merge Sort
  - Quick Sort
  - Radix Sort
  - Insertion Sort
- **Multithreading**: Each sorting algorithm runs in its own thread, allowing for faster and smoother animations.
- **Real-Time Visualization**: Watch the sorting process unfold in real-time.
- **Customization Options**: Configure parameters such as sorting speed, array size.

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Multithreading](#multithreading)
- [Sorting Algorithms](#sorting-algorithms)
- [Customization](#customization)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/sorting-visualizer-multithreading.git
    ```
2. **Open the project** in your favorite Java IDE. This project uses IntelliJ IDEA with the **Processing** library for rendering.
3. **Install dependencies**: 
   - Make sure to include the `Processing` library in your project. You can download it [here](https://processing.org/download/).
   - Add the `core.jar` file to your project’s classpath.
   
4. **Run the project**: Run the `Main.java` class to start the sorting visualizer.

## Usage

1. **Select Sorting Algorithm**: Upon running the program, you can select the desired sorting algorithm from the interface.
2. **Adjust Settings**:
   - **Array Size**: Set the size of the array to be sorted.
   - **Sorting Speed**: Adjust the speed of the visualization.

## Multithreading

This project leverages Java's **multithreading** capabilities to run each sorting algorithm in a separate thread. This ensures the visualization is smooth and does not block the UI thread.

Each sorting algorithm is assigned its own thread, allowing multiple algorithms to run simultaneously in different sections of the canvas.

### Example of Multithreading
```java
Thread sortingThread = new Thread(() -> {
    performSortingAlgorithm(array);
});
sortingThread.start();
