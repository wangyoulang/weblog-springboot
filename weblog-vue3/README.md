# weblog-vue3

This template should help get you started developing with Vue 3 in Vite.

## Recommended IDE Setup

[VSCode](https://code.visualstudio.com/) + [Volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar) (and disable Vetur).

## Customize configuration

See [Vite Configuration Reference](https://vitejs.dev/config/).

## Project Setup
创建前端项目
```shell
cd D:\IDEA_Projects\weblog
npm create vue@latest
```
> 执行过程中，会提示你命名新项目，我们命名为 weblog-vue3，以及是否需要开启一些诸如 TypeScript 和测试支持之类的可选功能，这里统一敲击回车键选择 No 即可

```sh
# 进入项目文件夹
cd weblog-vue3
# 安装项目所需依赖
npm install
# 启动项目
npm run dev
```
## 安装 vue-router
在命令行中，执行如下命令，安装 vue-router:

```sh
npm install vue-router
```
## 安装Tailwind CSS

```sh
npm install -D tailwindcss postcss autoprefixer
```
此命令会在你的项目中安装三个依赖，它们分别是：

1、tailwindcss：Tailwind CSS 框架本身。

2、postcss：一个用于转换 CSS 的工具。

3、autoprefixer：一个 PostCSS 插件，用于自动添加浏览器供应商前缀到 CSS 规则中，确保跨浏览器的兼容性。

然后，再执行如下命令：
```sh
npx tailwindcss init -p
```
此命令用于生成 tailwind.config.js 和 postcss.config.js 配置文件。

更多样式类，请参见：
https://tailwindcss.com/docs/installation

## 整合Flowbite

安装
```sh
npm install flowbite
```

使用flowbite：https://flowbite.com/docs/components/accordion/

## 整合 Element Plus
安装
```sh
npm install element-plus --save
```

安装unplugin-vue-components 和 unplugin-auto-import
```sh
npm install -D unplugin-vue-components unplugin-auto-import
```
