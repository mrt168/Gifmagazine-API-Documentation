# GIFMAGAZINE API Documentation

[http://api.gifmagazine.net/](http://api.gifmagazine.net/)

## 概要

このドキュメントでは[GIFMGAZINE](http://gifmagazine.net/) APIの仕様について説明します。

[GIFMAGAZINE GIF画像検索API 利用規約](http://api.gifmagazine.net/)に則って使用してください。

### リクエスト
APIの通信にはHTTPプロトコルを利用します。
ホストは以下のとおりです。

```
api.gifmagazine.net
```

### レスポンス形式
JSON形式でデータを返します。


### ステータスコード
- 200 - リクエストに正常に応答している場合。検索結果が0件の際も200を返す。
- 404 - 存在しないパスへのアクセスをしている場合。
- 500 - 内部エラー

### 利用制限
1リクエスト/秒まで受け付けます。

### 注意
CORSには対応していません。

## Endpoints

## GET /v1/gifs/search
検索結果を返します。

### パラメータ

- q(必須) - 検索したい単語
- limit - 返ってくる検索結果の件数。デフォルトは10件。最大100件。0~100以外の数値を指定した場合はデフォルト値が利用されます。
- offset - オフセット。デフォルトは0。
- safe - 0を指定するとR-18のgifを検索結果から除く。1を指定するとR-18のgifも含んだ検索結果を返す。デフォルトは0。

### Example

#### Request
```
GET /v1/gifs/search?q=猫&limit=2&offset=0&safe=0 HTTP/1.1
Accept: application/json
Content-Length: 0
Content-Type: application/x-www-form-urlencoded
Host: api.gifmagazine.net
```

#### Response
```
HTTP/1.1 200
Content-Type: application/json; charset=utf-8

{
  "data": [
    {
      "id": 4003,
      "url": "http://gifmagazine.net/post_images/4003",
      "title": "いけー！",
      "description": "#cat #猫 cat 猫",
      "user_name": "berururunnnnnnn",
      "file_size": 2525252,
      "rate": "g",
      "image": {
        "default": {
          "url": "http://img.gifmagazine.net/gifmagazine/images/4003/original.gif",
          "width": 500,
          "height": 400
        },
        "medium": {
          "url": "http://img.gifmagazine.net/gifmagazine/images/4003/medium.gif",
          "width": 300,
          "height": 240
        }
      }
    },
    {
      "id": 17011,
      "url": "http://gifmagazine.net/post_images/17011",
      "title": "猫とボブサップがノリノリ",
      "description": "ノリノリの猫がボブ・サップのような男の人とふりふりヴァイブレーションしている。無限ループするというgifの特性をうまく活かしたコラgifだ。",
      "user_name": "razokulover",
      "file_size": 2525252,
      "rate": "g",
      "image": {
        "default": {
          "url": "http://img.gifmagazine.net/gifmagazine/images/17011/original.gif",
          "width": 500,
          "height": 400
        },
        "medium": {
          "url": "http://img.gifmagazine.net/gifmagazine/images/17011/medium.gif",
          "width": 300,
          "height": 240
        }
      }
    }
  ],
  "pagination": {
    "total_count": 2,
    "count": 2,
    "offset": 0
  }
}
```
