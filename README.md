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

## Endpoints

- [Search](#get-v1gifssearch)
- [Emotion](#get-v1gifsemotion)

## GET /v1/gifs/search
検索結果を返します。

### パラメータ

- q(必須) - 検索したい単語
- limit - 返ってくる検索結果の件数。デフォルトは2件。最大2件。0~2以外の数値を指定した場合はデフォルト値が利用されます。
- offset - オフセット。デフォルトは0。最大0。
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

## GET /v1/gifs/emotion
[標準化されたユニコード絵文字](http://www.unicode.org/emoji/charts/full-emoji-list.html)を元に対応した感情のgif結果を返します。

### パラメータ

- q(必須) - 各種絵文字に対応するName(詳細は[現在対応済みの絵文字](#api%E3%81%A7%E5%AF%BE%E5%BF%9C%E6%B8%88%E3%81%BF%E3%81%AE%E7%B5%B5%E6%96%87%E5%AD%97)を参照)
- limit - 返ってくる検索結果の件数。デフォルトは2件。最大2件。0~2以外の数値を指定した場合はデフォルト値が利用されます。
- offset - オフセット。デフォルトは0。最大0。
- safe - 0を指定するとR-18のgifを検索結果から除く。1を指定するとR-18のgifも含んだ検索結果を返す。デフォルトは0。

#### 現在対応済みの絵文字

|              Emoji              |                Name               |
|:-------------------------------:|:---------------------------------:|
| :grin: | grin |
| :joy: | joy |
| :smiley: | smiley |
| :smile: | smile |
| :sweat_smile: | sweat_smile |
| :satisfied: | satisfied |
| :wink: | wink |
| :blush: | blush |
| :yum: | yum |
| :relieved: | relieved |
| :heart_eyes: | heart_eyes |
| :smirk: | smirk |
| :unamused: | unamused |
| :sweat: | sweat |
| :pensive: | pensive |
| :confounded: | confounded |
| :kissing_heart: | kissing_heart |
| :kissing_closed_eyes: | kissing_closed_eyes |
| :stuck_out_tongue_winking_eye: | stuck_out_tongue_winking_eye |
| :stuck_out_tongue_closed_eyes: | stuck_out_tongue_closed_eyes |
| :disappointed: | disappointed |
| :angry: | angry |
| :rage: | rage |
| :cry: | cry |
| :persevere: | persevere |
| :triumph: | triumph |
| :disappointed_relieved: | disappointed_relieved |
| :fearful: | fearful |
| :weary: | weary |
| :sleepy: | sleepy |
| :tired_face: | tired_face |
| :sob: | sob |
| :cold_sweat: | cold_sweat |
| :scream: | scream |
| :astonished: | astonished |
| :flushed: | flushed |
| :dizzy_face: | dizzy_face |
| :mask: | mask |

### Example

#### Request
```
GET /v1/gifs/emotion?q=yum&limit=2&offset=0&safe=0 HTTP/1.1
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
            "id": 727127,
            "url": "http://gifmagazine.net/post_images/727127",
            "title": "face savouring delicious food[9-6]",
            "description": "face savouring delicious food[9-6]",
            "user_name": "Mr.emotion",
            "file_size": 1191679,
            "rate": "g",
            "image": {
                "default": {
                    "url": "http://img.gifmagazine.net/gifmagazine/images/727127/original.gif",
                    "width": 393,
                    "height": 200
                },
                "medium": {
                    "url": "http://img.gifmagazine.net/gifmagazine/images/727127/medium.gif",
                    "width": 300,
                    "height": 153
                }
            }
        },
        {
            "id": 727159,
            "url": "http://gifmagazine.net/post_images/727159",
            "title": "face savouring delicious food[9-8]",
            "description": "face savouring delicious food[9-8]",
            "user_name": "Mr.emotion",
            "file_size": 1057956,
            "rate": "g",
            "image": {
                "default": {
                    "url": "http://img.gifmagazine.net/gifmagazine/images/727159/original.gif",
                    "width": 288,
                    "height": 200
                },
                "medium": {
                    "url": "http://img.gifmagazine.net/gifmagazine/images/727159/medium.gif",
                    "width": 300,
                    "height": 208
                }
            }
        }
    ],
    "pagination": {
        "total_count": 10,
        "count": 2,
        "offset": 0
    }
}
```
