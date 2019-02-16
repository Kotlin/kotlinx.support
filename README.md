# kotlinx.support
Provides extension and top-level functions to use JDK7/JDK8 features in Kotlin 1.0.

In Kotlin 1.1+ please use the standard library artifacts instead: [`kotlin-stdlib-jdk7`](https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib-jdk7) and [`kotlin-stdlib-jdk8`](https://mvnrepository.com/artifact/org.jetbrains.kotlin/kotlin-stdlib-jdk8).

[![obsolete JetBrains project](http://jb.gg/badges/obsolete.svg)](https://confluence.jetbrains.com/display/ALL/JetBrains+on+GitHub) [ ![Download](https://api.bintray.com/packages/kotlin/kotlinx.support/kotlinx.support/images/download.svg) ](https://bintray.com/kotlin/kotlinx.support/kotlinx.support/_latestVersion)

## Maven

Add jcenter repository (if you don't have it yet)

```xml
<repository>
    <snapshots>
        <enabled>false</enabled>
    </snapshots>
    <id>central</id>
    <name>bintray</name>
    <url>https://jcenter.bintray.com</url>
</repository>
```

Add a dependency:

```xml
<dependency>
    <groupId>org.jetbrains.kotlinx</groupId>
    <artifactId>kotlinx-support-jdk8</artifactId>
    <version>0.3</version>
</dependency>
```

## Gradle

Just add a dependency:

```groovy
compile 'org.jetbrains.kotlinx:kotlinx-support-jdk8:0.3'
```

jcenter repository should be configured by default in gradle, but if it's not you may need to include it:

```groovy
repositories {
    jcenter()
}
```

