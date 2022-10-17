package tools;

import javax.swing.*;
import java.util.Set;

public abstract class Graphic extends JPanel {
    protected abstract static class AnimeGraphicComponent {
        protected Integer totalFrames;
        protected Integer currentFrame = 0;

        public void inc() {
            if (currentFrame<totalFrames)
                currentFrame ++;
            else
                end();
        }
        protected abstract void end();
    }

    protected Set<AnimeGraphicComponent> animeBuffer;

    public void incAllComponents(){
        for (AnimeGraphicComponent component : animeBuffer)
            component.inc();
    }
}
