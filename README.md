# NL 面板 - Android 10 全屏网站浏览器

一个专为 Android 10+ 设备设计的自动启动全屏网站浏览器应用，适用于 kiosk 模式、数字标牌、触摸屏等场景。

## 功能特性

- ✅ **开机自动启动** - 设备启动后自动打开指定网站
- ✅ **全屏沉浸模式** - 隐藏状态栏和导航栏
- ✅ **返回键导航** - 支持网页内的返回历史
- ✅ **双指缩放禁用** - 防止用户缩放页面
- ✅ **加载失败检测** - 页面无法访问时自动弹出配置界面
- ✅ **HTTP/HTTPS 支持** - 兼容各类网站协议

## 修改网址

页面加载失败时，会自动弹出配置对话框让你修改网址。

或者在代码中修改默认网址：

编辑 [MainActivity.kt](app/src/main/java/com/kiosk/browser/MainActivity.kt#L21)：
```kotlin
private const val DEFAULT_URL = "http://10.0.0.88/uci"  // 修改这里
```

## 构建方式

### 方式一：Android Studio

1. 用 Android Studio 打开项目目录
2. 等待 Gradle 同步完成
3. 连接 Android 10+ 设备
4. 点击 Run → Run 'app'

### 方式二：命令行构建

```bash
# 生成 Gradle Wrapper（如需要）
gradlew wrapper

# 构建 Debug APK
./gradlew assembleDebug

# 构建 Release APK
./gradlew assembleRelease
```

## 安装 APK

```bash
# 通过 ADB 安装
adb install app/build/outputs/apk/debug/app-debug.apk

# 或直接将 APK 文件复制到设备上手动安装
```

## 项目结构

```
TouchSCN_4Inch_NLCORE/
├── app/
│   ├── build.gradle              # App 模块配置
│   └── src/main/
│       ├── AndroidManifest.xml   # 应用清单
│       ├── java/com/kiosk/browser/
│       │   ├── MainActivity.kt   # 主界面（WebView 浏览器）
│       │   └── BootReceiver.kt   # 开机广播接收器
│       └── res/
│           ├── layout/           # 布局文件
│           ├── drawable/         # 图标资源
│           ├── values/           # 字符串、颜色等
│           └── mipmap-*/         # 应用图标
├── build.gradle                  # 项目级配置
├── settings.gradle               # 项目设置
├── gradle.properties             # Gradle 属性
└── README.md                     # 本文档
```

## 权限说明

| 权限 | 用途 |
|------|------|
| INTERNET | 访问网络 |
| ACCESS_NETWORK_STATE | 检测网络状态 |
| RECEIVE_BOOT_COMPLETED | 监听开机完成广播 |

## 技术栈

- **语言**: Kotlin
- **最低 SDK**: Android 10 (API 29)
- **目标 SDK**: Android 13 (API 33)
- **UI 框架**: AndroidX + AppCompat
- **构建工具**: Gradle 8.4 + AGP 8.1.0

## 注意事项

1. 首次安装后需要手动打开一次应用，以确保开机自启权限生效
2. 如果应用没有自动启动，请在系统设置中手动开启"开机自启"权限
3. 不同设备对自适应图标的支持可能不同，如遇图标显示问题请反馈

## License

MIT License
