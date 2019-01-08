# AndroidFrameworkTraining

> Androidフレームワーク(Android SDK)のトレーニング
## 開発環境
- Android Studio 3.2.1以上
- Kotlin 1.3以上

Android Studioをダウンロードしてインストールしてください。<br> 
[Android Studio](https://developer.android.com/studio/)<br>

## 利用するSDKとライブラリ
### SDK
- Activity
- Fragment
- BottomNavigationView
- RecyclerView
- WebView
- Databinding
- Intent
- Bundle
- SharedPreferences

### ライブラリ
- Realm
- retrofit
- Coroutine

## 手順
Android Studioを利用してコーディングします。

### 環境構築 
### Hello! world.を表示する

## BottomNavigationView
メモ（後で更新）<br>
EmptyActivityで作成した前提<br>

bottom_navigation.xml作成<br>
マテリアルデザインアイコンを利用する場合はvector assetから必要なものを保存する<br>
MainActivityにFrameLayoutとBottomNaigationViewを設置<br>
各Fragmentのlayoutとclassを作成<br>
MainActivityにFragmentをコミットする処理を実装<br>
アイコンのカスタマイズ<br>
  selectorを作成<br>
	BottomNaigationViewのapp:itemTextColorとapp:itemIconTintに設定<br>

## HomeFragment作成
TextViewとButtomViewとLabelViewを配置<br>
HomeFragmentにリスナー実装<br>
Buttom押すとSharedPreferencesへ保存<br>
起動のたびにSharedPreferencesから取得する<br>

## TodoListFragment作成
AddButtomを用意<br>
TodoEditActivityかFragmentを用意<br>
TextViewと保存Button<br>
Realm導入、RealmModel作成<br>
ToDoをRealmへ保存<br>
RecyclerViewを用意する<br>
SelectDialogFragment<br>
編集と削除のActivity用意<br>

## OtherFragment作成
