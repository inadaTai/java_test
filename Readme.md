## docker環境を構築
docker-compose build

## dockerを立ち上げる
docker-compose up -d

## javaのアプリケーションコンテナに入る
docker-compose exec java bash

## ローカル環境立ち上げ(javaのアプリケーションコンテナに入ってる場合)
java -jar build/libs/test-0.0.1-SNAPSHOT.jar

## 変更の反映(javaのアプリケーションコンテナに入ってる場合)
sh gradlew build

## sh gradlew buildを実行し「xargs is not available」と表示されたら以下を実行。
microdnf install findutils