# javaeeの勉強用

## セットアップ

### Gitのインストール

### Dockerのインストール

[こちら](https://store.docker.com/editions/community/docker-ce-desktop-mac)からインストーラをダウンロードし、インストールする。

### NetBeansのインストール

[こちら](https://netbeans.org/downloads/start.html?platform=macosx&lang=ja&option=javaee)からインストーラをダウンロードし、インストールする。

## 開発環境構築

### ソースを取得

```
git clone <リポジトリURL>
```

### プロジェクトのインポート
NetBeansを起動し、[ファイル] -> [プロジェクトを開く]をクリックし、クローンしたソースを選択する。


### ブランチ作成

ターミナルを開き、以下のコマンドを実行する。

```
cd <プロジェクトのルート>
git checkout -b <ブランチ名>
```

### 動作確認

ターミナルを開き、以下のコマンドを実行する。

```
cd <プロジェクトのルート>
docker-compose up -d
```

プロジェクトを右クリックし、[実行]をクリックする。

## 課題

- 機能を正常に動作させること。

修正が完了したら以下のコマンドを実行する。

```
cd <プロジェクトのルート>
git push origin <作成したブランチ名>
```



