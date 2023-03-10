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

# 勉強の参考にしたサイトは以下になります。

## リレーション先相互参照する時に無限ループしてしまう問題に直面した時に参考にしたサイト
https://qiita.com/sengoku/items/56bc6319759fee6d15e3

## ５秒おきに定期実行する参考記事
https://spring.pleiades.io/guides/gs/scheduling-tasks/