# Kirk

[![CircleCI](https://circleci.com/gh/robfletcher/kirk/tree/master.svg?style=svg)](https://circleci.com/gh/robfletcher/kirk/tree/master)
[![Download](https://api.bintray.com/packages/robfletcher/maven/kirk-core/images/download.svg?version=0.1.0) ](https://bintray.com/robfletcher/maven/kirk-core/0.1.0/link)

Kirk is an assertion library for Kotlin intended for use with a test runner such as [JUnit](https://junit.org/junit5/) or [Spek](http://spekframework.org/).

The library is at an early stage of development, but usable.
Any suggestions, issue reports, contributions, or feedback are very welcome.

## Installation

Currently Kirk is hosted on Bintray.

```groovy
repositories { 
  maven { url "https://dl.bintray.com/robfletcher/maven" } 
}

testCompile "io.github.robfletcher.kirk:kirk-core:0.1.0"
```

## Using Kirk

Please see the [project documentation](https://robfletcher.github.io/kirk/) and [API docs](https://robfletcher.github.io/kirk/api/kirk). 