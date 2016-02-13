package oscar.dicaprio.utils;

import com.badlogic.gdx.Gdx;

/**
 * Created by: Anton Shkurenko (cullycross)
 * Project: DiCaprio
 * Date: 2/11/16
 * Code style: SquareAndroid (https://github.com/square/java-code-styles)
 * Follow me: @tonyshkurenko
 */

/**
 * Later store here crystals, other coins, save them to the database, online storage, w/e
 */
public class Bank {

  private static final String TAG = Bank.class.getSimpleName();

  private static final Bank INSTANCE = new Bank();

  private int mCoins = 0;

  public static Bank getInstance() {
    return INSTANCE;
  }

  private Bank() {

  }

  public void addCoins(int coins) {
    if(coins > 0) {
      mCoins += coins;
      Gdx.app.log(TAG, "::addCoins(" + coins + "), total: " + mCoins);
    }
  }

  public void incrementCoins() {
    mCoins++;
    Gdx.app.log(TAG, "::incrementCoins, total: " + mCoins);
  }
}
