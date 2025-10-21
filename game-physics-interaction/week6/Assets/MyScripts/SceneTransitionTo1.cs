using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneTransitionTo1 : MonoBehaviour
{
    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if ( Input.GetKeyDown(KeyCode.F1))
        {
            SceneManager.LoadScene(0, LoadSceneMode.Single);
        }
    }
}
