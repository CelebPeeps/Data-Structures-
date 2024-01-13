import java.io.FileNotFoundException;

public class EvilSecretWordGame
{
    public static void main(String[] args) throws FileNotFoundException
    {
        EvilSecretWord evil = new EvilSecretWord("dictionary.txt", true);
        //EvilSecretWord evil = new EvilSecretWord("dictionary.txt", false);
        evil.playGame();
    }
}
