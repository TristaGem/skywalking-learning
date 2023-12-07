##3.2
https://www.notion.so/03-Java-Agent-cf6a68cf6efa4df5b25316726fad846b?pvs=4#af8b34ae70ec4e409a5897d1ab8aac28

##3.3
通过bytebuddy为以com.czh为前缀的方法加上计时器

##3.4
在 Java 5 中，Java 开发者只能通过 Java Agent 中的 premain() 方法在 main() 方法执行之前进行一些操作，这种方式在一定程度上限制了灵活性。Java 6 针对这种状况做出了改进，提供了一个 agentmain() 方法，Java 开发者可以在 main() 方法执行以后执行 agentmain() 方法实现一些特殊功能。

agentmain() 方法同样有两个重载，它们的参数与 premain() 方法相同，而且前者优先级也是高于后者的：

```java
public static void agentmain (String agentArgs,
      Instrumentation inst);[1]
public static void agentmain (String agentArgs); [2]
```

agentmain() 方法主要用在 JVM Attach 工具中，Attach API 是 Java 的扩展 API，可以向目标 JVM “附着”（Attach）一个代理工具程序，而这个代理工具程序的入口就是 agentmain() 方法。

Attach API 中有 2 个核心类需要特别说明：

- **VirtualMachine** 是对一个 Java 虚拟机的抽象，在 Attach 工具程序监控目标虚拟机的时候会用到该类。VirtualMachine 提供了 JVM 枚举、Attach、Detach 等基本操作。
- **VirtualMachineDescriptor** 是一个描述虚拟机的容器类，后面示例中会介绍它如何与 VirtualMachine 配合使用。