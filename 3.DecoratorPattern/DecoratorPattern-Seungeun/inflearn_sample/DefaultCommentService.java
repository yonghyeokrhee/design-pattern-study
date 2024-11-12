package inflearn_sample;

public class DefaultCommentService implements CommentService {
    @Override
    public void writeComment(String comment) {
        System.out.println(comment);
    }
}
