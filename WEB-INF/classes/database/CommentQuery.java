package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import bean.commentBean;


public class CommentQuery{
    public static List<commentBean> getQueryList(){

        List<commentBean> list = new ArrayList<commentBean>();


        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Oracleに接続する
            Connection cn=
                DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","bbs","bbs");
            System.out.println("接続完了");

            //select文
            String sql="SELECT comment_id,com,name FROM comment_table ORDER BY comment_id ASC";

            //Statementインターフェイスを実装するクラスをインスタンス化する
            Statement st=cn.createStatement();

            //select文を実行し
            //ResultSetインターフェイスを実装したクラスの
            //インスタンスが返る
            ResultSet rs=st.executeQuery(sql);

            //カーソルを一行だけスクロールし、データをフェッチする
            while(rs.next()){
                commentBean cb = new commentBean();

                int comment_id = rs.getInt(1);	//1列目のデータを取得
                String comment = rs.getString(2);	//2列目のデータを取得
                String name = rs.getString(3);	//3列目のデータを取得
                
                System.out.println("comment_id="+comment_id);
                cb.setComment_id(comment_id);
                cb.setName(name);
                cb.setComment(comment);
                
                list.add(cb);

            }


            //Oracleから切断する
            cn.close();

            System.out.println("切断完了");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("クラスがないみたい。");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("SQL関連の例外みたい。");
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;

    }
}











