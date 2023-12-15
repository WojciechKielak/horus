import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure {
    private List<Block> blocks;

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for(Block block : blocks) {
            if (block instanceof CompositeBlock) {
                Optional<Block> colorBlock = findComposeBlockByColor(color, (CompositeBlock) block);
                if(colorBlock.isPresent()){
                    return colorBlock;
                }
            } else if (block.getColor().equals(color)) return Optional.of(block);
        }
        return Optional.empty();
    }
    private Optional<Block> findComposeBlockByColor(String color,  CompositeBlock compositeBlock) {
        for(Block block : blocks) {
            if (block instanceof CompositeBlock) {
                Optional<Block> colorBlock = findComposeBlockByColor(color, (CompositeBlock) block);
                if(colorBlock.isPresent()){
                    return colorBlock;
                }
            } else if (block.getColor().equals(color)) return Optional.of(block);
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> materialBlocks = new ArrayList<>();
        for(Block block : blocks) {
            if (block instanceof CompositeBlock) {
                materialBlocks.addAll(findComposeBlocksByMaterial(material, (CompositeBlock) block));
            } else if (block.getMaterial().equals(material)) materialBlocks.add(block);
        }
        return materialBlocks;
    }

    public List<Block> findComposeBlocksByMaterial(String material, CompositeBlock compositeBlock) {
        List<Block> materialBlocks = new ArrayList<>();
        for(Block block : blocks){
            if ( block instanceof CompositeBlock ){
                materialBlocks.addAll(findComposeBlocksByMaterial(material, (CompositeBlock) block));
            }else materialBlocks.add(block);
        }
        return materialBlocks;
    }


    @Override
    public int count() {
        int counter = 0;
        for(Block block : blocks){
            if ( block instanceof CompositeBlock ){
                counter+= countCompositeBlock( (CompositeBlock) block );
            }else counter ++;
        }
        return counter;
    }

    private int countCompositeBlock(CompositeBlock compositeBlock) {
        int counter = 0;
        for(Block block : compositeBlock.getBlocks()){
            if ( block instanceof CompositeBlock ){
                counter+= countCompositeBlock( (CompositeBlock) block );
            }else counter ++;
        }
        return counter;
    }
}

