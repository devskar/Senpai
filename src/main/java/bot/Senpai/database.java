package bot.Senpai;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.gen.exc.ReqlError;
import com.rethinkdb.gen.exc.ReqlQueryLogicError;
import com.rethinkdb.model.MapObject;
import com.rethinkdb.net.Connection;
import com.rethinkdb.net.Cursor;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.User;

/**
 * Coded by Oskar#7402
 * At 17.05.2018
 * github.com/oskardevkappa/
 */

public class database{

    public static final RethinkDB r = RethinkDB.r;
    public final String dbname = "Senpai";
    public final String usertable = "users";
    public final String guildtable = "guilds";
    public final String membertable = "members";

    static Connection conn;

    public database(){

    }


    public void Connect(){
        try {
            conn = r.connection()
                    .db(dbname)
                    .hostname("localhost")
                    .port(28015).connect();

            if (conn.isOpen()){
                System.out.println("[Database] Connected!");
            }

        }catch(Exception e){
            System.out.println("[Database] Connection failed");
        }
    }

    public void createTable(String name){

        r.tableCreate(name).run(conn);

    }

    public void writeUser(User u) {
        try {
            Cursor cursor = r.table(usertable)
                    .filter(row ->
                            row.g("userid")
                                    .eq(u.getId()))
                    .run(conn);
            if (!cursor.hasNext()) {
                r.table(usertable).insert(
                        r.array(
                                r.hashMap("name", u.getName())
                                        .with("userid", u.getId())
                        )
                ).run(conn);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void writeMember(Member m) {
        try {
            Cursor cursor = r.table(guildtable)
                    .filter(row ->
                            row.g("memberid")
                                    .eq(m.getUser().getId()))
                    .run(conn);
            Cursor cursor2 = r.table(guildtable)
                    .filter(row ->
                            row.g("guildid")
                                    .eq(m.getUser().getId()))
                    .run(conn);
            if (!cursor.hasNext()) {
                r.table(usertable).insert(
                        r.array(
                                r.hashMap("name", m.getUser().getName())
                                        .with("memberid", m.getUser().getId())
                        )
                ).run(conn);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void get(String table, String content){



    }


}
