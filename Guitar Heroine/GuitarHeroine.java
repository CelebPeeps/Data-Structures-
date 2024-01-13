/**
 * This GuitarHeroine object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarHeroine
{
     public static void main(String[] args) 
    {
        GuitarString[] array = new GuitarString[37];
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        for(int i = 0; i < array.length; i++)
        {
            array[i]= new GuitarString((int)(440)*Math.pow(1.05956, i-24));
        }
        while (true) 
        {
            if (StdDraw.hasNextKeyTyped()) 
            {
                char key = StdDraw.nextKeyTyped();
                if(keyboard.indexOf(key)!=-1)
                {
                    array[keyboard.indexOf(key)].pluck();
                }
            }
            double position = 0.0;
            for(int i = 0; i < array.length; i ++)
            {
                position+=array[i].sample();
            }
            StdAudio.play(position);
            for(int i = 0; i < array.length; i++)
            {
                array[i].tic();
            }
        }
    }
}
