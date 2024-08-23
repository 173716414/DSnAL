本地沙箱流程：

1. 读取内容保存为文件
   1. 创建文件夹，隔离存放用户代码
   2. 主要使用FileUtil
2. 编译文件
   1. 使用Process compileProcess
   2. 抽取出执行和获得返回信息的代码
3. 执行文件
   1. 使用Process compileProcess
   2. 使用抽取出执行和获得返回信息的代码
4. 整理输出
5. 删除文件
   1. FileUtil.*del*
6. 错误处理
   1. 超时控制
      - 开启守护线程
      - 到时将主线程销毁