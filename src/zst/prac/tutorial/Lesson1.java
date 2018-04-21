package zst.prac.tutorial;

import javafx.event.EventHandler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * メインメソッドをもつクラス<br/>
 * Lesson1. JavaFxでのはじめの一歩<br/>
 * Getting started JavaFx on Tutorial<br/>
 * この文章がさ記載されている部分をJavaDocコメントと言います。<br/>
 * 
 * @see https://docs.oracle.com/javafx/2/get_started/hello_world.htm
 * @author Takunoji
 */
public class Lesson1 extends Application {
	/**
	 * はじめのプログラムは「Hello World」<br/>
	 * どの言語でもやるのです。<br/>
	 * 主な用途としては、プログラムの疎通確認をやります。<br/>
	 * ※プログラムの実行環境を作成した後にプログラムが走るか確認<br/>
	 * 
	 * このメソッドを<b>「メインメソッド」</b>と呼びます。
	 * @param args: プログラム引数
	 */
	public static void main(String[] args) {
		// Mainメソッド
		launch(args);
	}

	/**
	 * プログラミング学習の基本は「写経」です。<br/>
	 * 意味はわからなくても「とりあえず」自分でコードを描いてください。<br/>
	 * インポートするのはjavafx.XXXを選択します。(IDEを使用している場合)
	 */
	@Override
	public void start(Stage primaryStage) {
		// メンバメソッド(親クラス)
		primaryStage.setTitle("Hello World");

		Button btn = new Button();
		btn.setText("Say Hello World!");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.show();
	}
}
