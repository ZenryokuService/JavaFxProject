package zst.prac.lwjgl;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.nio.IntBuffer;

/**
 * 初回のプログラム起動確認とサンプル画面を起動してみる
 * 
 * @author takunoji
 * @see https://www.lwjgl.org/guide
 */
public class TestSetUp {
	// The window handle
	private long window;

	/**
	 * 初期化処理<BR>
	 * ※間はよくわからなかったので　TODOコメントをつけております。
	 * エラー時のコールバックのデフォルト設定<BR>
	 * GLFWの終了処理の設定と自由呼び出しのコールバック関数指定
	 */
	public void run() {
		System.out.println("LWJGJL Version = " + Version.getVersion());
		// 初期化処理
		init();
		// TODO-[よくわかりませんでした。]
		loop();
		// TODO-[よくわかりませんでした。]
		// Free the window callbacks and destroy the window
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		// Terminate GLFW and free the error callback
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}

	/**
	 * セットアップ処理<BR>
	 * 1. エラー時のメッセージ出力先を設定する
	 * 2. GLFWの初期化を行う
	 *    -ウィンドウを非表示状態にする
	 *    -ウィンドウのリサイズを可能にする
	 *    -ウィンドウの作成
	 *    -ウィンドウの位置を指定(中心)
	 *  3. OpenGLのコンテキスト作成
	 *  4. ウィンドウの表示
	 */
	private void init() {
		// エラー出力へメッセージを出力する
		GLFWErrorCallback.createPrint(System.err);
		// GLFWを初期化する
		if ( !glfwInit() ) {
			throw new IllegalStateException("GLFWが初期化できませんでした。");
		}
		// GLFWの設定
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // ウィンドウ作成後に表示にする
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // ウィンドウをリサイズ可能にする
		// ウィンドウ作成(NULL=>MemoryUtil.NULL(long型))
		window = glfwCreateWindow(300, 300, "Hello World", NULL, NULL);
		if ( window == NULL) {
			throw new RuntimeException("GLFWウィンドウの作成に失敗しました。");
		}
		// ウィンドウのコールバック関数などを指定する
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) ->{
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true);
		});
		// スレッドスタックの取得と新しいフレームをプッシュする
		try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);
			// glfwCreateWindow経由でウィンドウサイズを取得する
			glfwGetWindowSize(window, pWidth, pHeight);
			// プライマリーモニターの解決を行う
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
			// ウィンドウの中心
			glfwSetWindowPos(window
					, (vidmode.width() - pWidth.get(0)) / 2
					, (vidmode.height() - pHeight.get(0) / 2));
		}
		// OpenGLのコンテキストを作成する
		glfwMakeContextCurrent(window);
		// v-syncをONにする？
		glfwSwapInterval(1);
		// ウィンドウを表示する
		glfwShowWindow(window);
	}

	/**
	 *TODO: 内容を理解して処理概要を記載する
	 */
	private void loop() {
		/*
		 * This line is critical for LWJGL's interoperation with GLFW's
		 * OpenGL context, or any context that is managed externally.
		 * LWJGL detects the context that is current in the current thread,
		 * creates the GLCapabilities instance and makes the OpenGL
		 * bindings available for use.
		 */
		GL.createCapabilities();
		// Clear Colorの設定 「1.0f」フロート型の数値
		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);

		// Run the rendering loop until the user has attempted to close
		// the window or has pressed the ESCAPE key.
		while( !glfwWindowShouldClose(window)) {
			// frame bufferをクリアする
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			// Poll for window events. The key callback above will only be
			// invoked during this call.
			glfwPollEvents();
		}
	}

	/**
	 * メインメソッド、sample codeを実行する
	 * @param args　プログラム引数
	 */
	public static void main(String[] args) {
		// メインメソッドはクラス内にあるが「static」なのでクラスをnewする
		TestSetUp test = new TestSetUp();
		test.run();
	}
}
