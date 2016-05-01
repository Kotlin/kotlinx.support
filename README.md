# kotlinx.support
Provides extension and top-level functions to use JDK7/JDK8 features in Kotlin 1.0

[ ![Download](https://api.bintray.com/packages/kotlin/kotlinx.support/kotlinx.support/images/download.svg) ](https://bintray.com/kotlin/kotlinx.support/kotlinx.support/_latestVersion)

## Maven

Add jcenter repository (if you don't have it yet)

```xml
<repository>
    <snapshots>
        <enabled>false</enabled>
    </snapshots>
    <id>central</id>
    <name>bintray</name>
    <url>http://jcenter.bintray.com</url>
</repository>
```

Add a dependency:

```xml
<dependency>
    <groupId>org.jetbrains.kotlinx</groupId>
    <artifactId>kotlinx-support-jdk8</artifactId>
    <version>0.1</version>
</dependency>
```

## Gradle

Just add a dependency:

```groovy
compile 'org.jetbrains.kotlinx:kotlinx-support-jdk8:0.1'
```

jcenter repository should be configured by default in gradle, but if it's not you may need to include it:

```groovy
repositories {
    jcenter()
}
```

