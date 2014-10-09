package rabbitescape.engine;

import static rabbitescape.engine.ChangeDescription.State.*;
import static rabbitescape.engine.Direction.*;

public class Entrance extends Thing
{
    private int delay;

    private int timeToNextRabbit;

    public Entrance( int x, int y )
    {
        super( x, y, ENTRANCE );
        delay = -1;
        timeToNextRabbit = 0;
    }

    @Override
    public void calcNewState( World world )
    {
        if ( delay == -1 )
        {
            delay = world.rabbit_delay;
        }
    }

    @Override
    public void step( World world )
    {
        if ( world.num_waiting <= 0 )
        {
            return;
        }

        if ( timeToNextRabbit == 0 )
        {
            timeToNextRabbit = delay;

            world.enterRabbit( new Rabbit( x, y + 1, RIGHT ) );
        }
        --timeToNextRabbit;
    }
}
