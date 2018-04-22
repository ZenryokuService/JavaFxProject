package zst.javafx.tutorial;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * メインメソッドをもつクラス<br/>
 * Lesson1. JavaFxでのはじめの一歩<br/>
 * Getting started JavaFx on Tutorial<br/>
 * この文章がさ記載されている部分をJavaDocコメントと言います。<br/>
 * 
 * @see https://docs.oracle.com/javafx/2/get_started/form.htm
 * @author Takunoji
 */
public class Lesson2 extends Application {
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
		// GridPaneマス目状のレイアウト
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		// Padding 隙間、画面のテキストフィールドなどの間の幅
		grid.setPadding(new Insets(25, 25, 25, 25));

		/*
		 * JavaFxでは、Starge -> Scene -> Node(画面のコンポーネント)
		 * の順番で、設定する必要がある
		 */
		// SceneにGridを設定する
		Scene scene = new Scene(grid, 300, 275);
		// SceneをStageに登録
		primaryStage.setScene(scene);
		Text scenetitle = new Text("Welcome2");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		// 画面のコンポーネントを作成しGridへ登録する
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);

		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);

		Label pw = new Label("Password:");
		grid.add(pw, 0, 2);

		PasswordField pwBox = new PasswordField();
		grid.add(pwBox, 1, 2);
		
		Button btn = new Button();
		btn.setText("Say Hello World2!");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
			}
		});
		// GridにHBox(横のレイアウト)を登録する
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		// HBoxへボタンを登録
		hbBtn.getChildren().add(btn);
		//Gridへボタンの登録
		grid.add(hbBtn, 1, 4);
		// RootPane(コンポーネントのコンテナ)
		StackPane root = new StackPane();
		
		root.getChildren().add(grid);
		primaryStage.setScene(new Scene(root, 300, 200));
		primaryStage.show();
	}
}
