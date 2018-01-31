# JavaEE7の勉強用

## 準備

※すでにインストール済みの場合は、インストール不要。

### Gitのインストール

[こちら](https://git-scm.com/downloads)からインストーラをダウンロードし、インストールする。

### Dockerのインストール

[こちら](https://store.docker.com/editions/community/docker-ce-desktop-mac)からインストーラをダウンロードし、インストールする。

### NetBeansのインストール

[こちら](https://netbeans.org/downloads/start.html?platform=macosx&lang=ja&option=javaee)からインストーラをダウンロードし、インストールする。

## 環境構築

※作業用のディレクトリに移動してから行ってください。

### ソースを取得

```
git clone <リポジトリURL>
```

### プロジェクトのインポート
NetBeansを起動し、[ファイル] -> [プロジェクトを開く]をクリックし、Gitで取得したソース（フォルダ）を選択する。


### ブランチ作成

ターミナルを開き、以下のコマンドを実行する。

```
cd javaee-todo
git checkout -b <ブランチ名>
```

### 動作確認

ターミナルを開き、以下のコマンドを実行する。

```
docker-compose up -d
```

Netbeansのjavaee-todoプロジェクトを右クリックし、[実行]をクリックする。

## 課題

- 機能を正常に動作させること。

修正が完了したら以下のコマンドを実行する。

```
cd javaee-todo
git push origin <作成したブランチ名>
```



