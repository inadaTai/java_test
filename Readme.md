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

## APIドキュメントについて、swaggerAPIを導入した。
https://qiita.com/nooboolean/items/ee794ec4b30d9e93bf9f

## Interface
インターフェースと抽象クラスの使い分け
インターフェースや抽象クラスは、メソッドの具体的な処理内容を記述しないことから、両者に違いはないように思えるかもしれませんが、インターフェースはクラスで共通する仕様を定義するとき、抽象クラスは他のクラスの処理の骨組みを定義するときに利用されます

## Serializable
https://qiita.com/NBT/items/9f76c9fd1c7a90506658

# Flaywayのコマンドについて
コミュニティエディションではロールバックのコマンドが使用できない。
そのため、ロールバックしたいテーブルが出た場合は、以下のような対処が想定される。

・任意テーブルを削除するSQLスクリプトを生成しテーブル削除。
(※想定デメリットとしては、マイグレーションファイルが重ばってしまう。)

・他のマイグレーション管理ツールを使いロールバック機能を利用

## マイグレート
./gradlew flywayMigrate

## 現状マイグレートされているsqlファイルを確認する。
./gradlew flywayInfo

## ロールバック(エンタープライズエディション限定)
./gradlew flywayUndo

## ロールバック2つ前のマイグレーションファイル(エンタープライズエディション限定)
./gradlew flywayUndo -Pcount=2
