package baseball.gameutil;

import baseball.game.validate.ValidateInput;
import baseball.game.validate.ValidateInputGame;
import baseball.game.validate.ValidateInputRerun;
import baseball.message.MessageString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateInputBaseballTest {

    @Test
    void 게임중_세_자리_미만_문자열() {
        //given
        String input = "13";
        ValidateInput validateInputGame = new ValidateInputGame();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.GAME_LEN_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_네_자리_이상_문자열() {
        //given
        String input = "0123";
        ValidateInput validateInputGame = new ValidateInputGame();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.GAME_LEN_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_금지된_문자열_존재() {
        //given
        String input = "1a3";
        ValidateInput validateInputGame = new ValidateInputGame();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_GAME_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_제로가_포함된_경우() {
        String input = "103";
        ValidateInput validateInputGame = new ValidateInputGame();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_GAME_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_중복된_문자열이_온_경우() {
        String input = "113";
        ValidateInput validateInputGame = new ValidateInputGame();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputGame.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_GAME_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임중_올바른_문자열이_온_경우() {
        String input = "123";
        ValidateInput validateInputGame = new ValidateInputGame();

        //when
        String ret = validateInputGame.validate(input);

        //then
        Assertions.assertEquals(ret, input);
    }

    @Test
    void 게임재게_두_자리_이상_문자열() {
        //given
        String input = "02";
        ValidateInput validateInputRerun = new ValidateInputRerun();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputRerun.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_RERUN_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_금지된_문자열_존재() {
        //given
        String input = "A";
        ValidateInput validateInputRerun = new ValidateInputRerun();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputRerun.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_RERUN_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_다른숫자가_들어온_경우() {
        String input = "0";
        ValidateInput validateInputRerun = new ValidateInputRerun();

        //when
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class,
            () -> {
                validateInputRerun.validate(input);
            }
        );

        //then
        String expected = MessageString.WRONG_RERUN_INPUT_ERROR_STRING;
        String actual = exception.getMessage();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void 게임재게_숫자가_온_경우() {
        String input = "1";
        ValidateInput validateInputRerun = new ValidateInputRerun();

        //when
        String ret = validateInputRerun.validate(input);

        //then
        Assertions.assertEquals(ret, input);
    }
}
