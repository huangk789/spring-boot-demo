# 基础镜像
FROM hub.mingyuanyun.com/tools/anapsix/alpine-java:8_jdk
# 设定时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
# 拷贝jar包
COPY target/admin-client.jar /app.jar

# 切换工作路径
WORKDIR /app

# 暴露应用程序运行的端口
EXPOSE 8080
# 入口
ENTRYPOINT ["java", "-jar", "/app.jar"]
