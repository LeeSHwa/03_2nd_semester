using UnityEngine;

public class drawGUIs : MonoBehaviour
{
    public PlayerCtrl playerCtrl;
    int jump;
    float timer;

    private GUIStyle textStyle;


    void Start()
    {
        jump = playerCtrl.jump_power;
    }

    // Update is called once per frame
    void Update()
    {
        timer += Time.deltaTime;
    }

    private void OnGUI()
    {

        if (textStyle == null)
        {
            textStyle = new GUIStyle(GUI.skin.label);

            textStyle.fontSize = 28;
        }

        GUI.Label(new Rect(20, 0, 256, 32), "time : " + timer,textStyle);
        GUI.Label(new Rect(20, 35, 128, 32), "Jump : " + jump, textStyle);
    }
}
