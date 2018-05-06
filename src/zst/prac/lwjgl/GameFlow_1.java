package zst.prac.lwjgl;

/**
 * チュートリアル１
 * ゲームのプログラム的な動きを理解する
 * 
 * @author takunoji
 * @see https://github.com/SilverTiger/lwjgl3-tutorial/wiki/Game-loops
 */
public class GameFlow_1 {
	/**
	 * 起動フラグ
	 * 起動中はTRUE
	 * 終了するときに FALSE
	 */
	private boolean running = false;
	
	/**
	 * チュートリアル１を起動する
	 * 「LWJGLの基本的な処理フロー」
	 * 1. init(): 初期化処理、ウィンドウの作成〜リソースの読み込み
	 * 2. gameLoop(): 入力→データなどの更新→画面のレンダリング
	 * 3. dispose(): ゲームで使用した全てのリソースを解放する
	 * @param args プログラム引数
	 */
	public static void main(String[] args) {
		System.out.println("1: メインメソッド起動");
		GameFlow_1 flow = new GameFlow_1();
		// ゲームのスタート
		flow.startGame();
	}

	/**
	 * ゲームの開始処理
	 */
	public void startGame() {
		System.out.println("2: ゲームを開始します");
		init();
		gameLoop();
		dispose();
	}
	////////////////////////////////////////////
	// <<ゲームの外枠の処理>>
	// 1. 初期化
	// 2. ゲームのループ処理
	// 3. 終了処理
	////////////////////////////////////////////
	/**
	 * 初期化処理、以下の処理を行う
	 * 1. ウィンドウの作成
	 * 2. リソースの読み込み
	 */
	public void init() {
		System.out.println("3: ゲームを初期化します");
		// ゲームを起動するので起動フラグをTRUEにする
		running = true;
		// TODO-[初期化処理を実装する]
	}

	/**
	 * 終了処理
	 */
	public void dispose() {
		// TODO-[ゲームで使用したリソース全てを解放する(終了処理)]
	}
	/**
	 * ゲーム起動中の処理
	 * ゲーム起動中は無限ループしている中で
	 * 
	 * 以下の処理を繰り返す
	 * 1. 入力を受ける
	 * 2. データなどの更新
	 * 3. 画面を更新する
	 */
	public void gameLoop() {
		System.out.println("4: ゲームループを開始します");
		long sleepTime = 1000L / 60L; 

		// ゲーム起動中は無限ループする
		// FIXME-[ここは修正する必要があるときに使用する]
		// 起動した後にFALSEに戻す処理がないので止まらなくなる
		while(running) {
			input();
			update();
			render();
			// プログラムはものすごいスピートで
			// 処理をしているので処理休憩する時間を作る
			sleep(sleepTime);
			// FIXME-[間違って実行したとき用]
			running = false;
			System.out.println("9: ゲームループをぬけます");
		}
	}

	////////////////////////////////////////////
	// <<ゲームのループ処理>>
	// 1. 入力を受け対応する処理を行う
	// 2. データなどの更新処理
	// 3. 画面のレンダリング処理
	// 4. 処理を少し止める(スピートの調節)
	////////////////////////////////////////////

	/**
	 * 入力に対する処理
	 */
	public void input() {
		System.out.println("5: 入力処理を実行します");
		// TODO-[入力に対応する処理を実装]
	}

	/**
	 * データなどの更新処理
	 */
	public void update() {
		System.out.println("6: ゲームデータなどの更新処理を行います");
		// TODO-[更新の処理を実装する]
	}

	/**
	 * 画面のレンダリング処理
	 */
	public void render() {
		System.out.println("7: ゲーム画面をレンダリングします");
		// TODO-[画面のレンダリングの実装]
	}

	/**
	 * 16ミリ秒の固定スリープ時間があるため、ゲームは毎秒62.5回更新されます。
	 * ※サイトより引用
	 * @param time
	 */
	public void sleep(long time) {
		System.out.println("8: 処理が早すぎるのでスリープします");
		// TODO-[スリープ処理を実装する]
	}
}
